package com.kwai.video.ksvodplayerkit;

import android.content.Context;
import android.text.TextUtils;
import com.kwai.video.player.kwai_player.KwaiPlayerVodBuilder;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class KSVodPlayerBuilder {

    /* renamed from: a  reason: collision with root package name */
    public Context f37219a;

    /* renamed from: b  reason: collision with root package name */
    public String f37220b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f37221c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f37222d;

    /* renamed from: e  reason: collision with root package name */
    public l f37223e;

    /* renamed from: h  reason: collision with root package name */
    public com.kwai.video.ksvodplayerkit.b.h f37226h;
    public int j;
    public Map<String, String> k;
    public com.kwai.video.ksvodplayerkit.c.b m;
    public boolean n;
    public long o;
    public KwaiPlayerVodBuilder p;

    /* renamed from: f  reason: collision with root package name */
    public VodPlayEnterType f37224f = VodPlayEnterType.CLICK;

    /* renamed from: g  reason: collision with root package name */
    public boolean f37225g = true;
    public int i = 0;
    public String l = "N/A";

    /* loaded from: classes6.dex */
    public enum VodPlayEnterType {
        SLIDE,
        CLICK
    }

    public KSVodPlayerBuilder(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Wrong Input Arguments! Context con't be null!");
        }
        this.p = new KwaiPlayerVodBuilder(context);
        this.f37219a = context;
    }

    public KSVodPlayerBuilder a(String str) {
        this.f37220b = str;
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
        List<String> list;
        com.kwai.video.ksvodplayerkit.b.h hVar;
        List<com.kwai.video.ksvodplayerkit.b.i> list2;
        if (this.f37219a != null) {
            String str = this.f37220b;
            if ((str == null || TextUtils.isEmpty(str)) && (((list = this.f37221c) == null || list.isEmpty()) && ((hVar = this.f37226h) == null || (list2 = hVar.f37247b) == null || list2.isEmpty()))) {
                throw new IllegalArgumentException("Wrong Input Arguments! Please SetDatasource!");
            }
            return new g(this);
        }
        throw new IllegalArgumentException("Wrong Input Arguments! Please set context!");
    }
}

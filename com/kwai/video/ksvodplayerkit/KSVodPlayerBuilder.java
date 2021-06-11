package com.kwai.video.ksvodplayerkit;

import android.content.Context;
import android.text.TextUtils;
import com.kwai.video.player.kwai_player.KwaiPlayerVodBuilder;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class KSVodPlayerBuilder {

    /* renamed from: a  reason: collision with root package name */
    public Context f37988a;

    /* renamed from: b  reason: collision with root package name */
    public String f37989b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f37990c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f37991d;

    /* renamed from: e  reason: collision with root package name */
    public l f37992e;

    /* renamed from: h  reason: collision with root package name */
    public com.kwai.video.ksvodplayerkit.b.h f37995h;
    public int j;
    public Map<String, String> k;
    public com.kwai.video.ksvodplayerkit.c.b m;
    public boolean n;
    public long o;
    public KwaiPlayerVodBuilder p;

    /* renamed from: f  reason: collision with root package name */
    public VodPlayEnterType f37993f = VodPlayEnterType.CLICK;

    /* renamed from: g  reason: collision with root package name */
    public boolean f37994g = true;

    /* renamed from: i  reason: collision with root package name */
    public int f37996i = 0;
    public String l = "N/A";

    /* loaded from: classes7.dex */
    public enum VodPlayEnterType {
        SLIDE,
        CLICK
    }

    public KSVodPlayerBuilder(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Wrong Input Arguments! Context con't be null!");
        }
        this.p = new KwaiPlayerVodBuilder(context);
        this.f37988a = context;
    }

    public KSVodPlayerBuilder a(String str) {
        this.f37989b = str;
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
        if (this.f37988a != null) {
            String str = this.f37989b;
            if ((str == null || TextUtils.isEmpty(str)) && (((list = this.f37990c) == null || list.isEmpty()) && ((hVar = this.f37995h) == null || (list2 = hVar.f38018b) == null || list2.isEmpty()))) {
                throw new IllegalArgumentException("Wrong Input Arguments! Please SetDatasource!");
            }
            return new g(this);
        }
        throw new IllegalArgumentException("Wrong Input Arguments! Please set context!");
    }
}

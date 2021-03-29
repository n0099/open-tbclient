package com.bytedance.sdk.openadsdk.i.a;

import android.graphics.Bitmap;
import com.bytedance.sdk.openadsdk.utils.f;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f29493a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f29494b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.c.c.b.d.a> f29495c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f29496d;

    public d(byte[] bArr) {
        this.f29493a = null;
        this.f29494b = null;
        this.f29495c = null;
        this.f29496d = null;
        this.f29493a = bArr;
    }

    public Bitmap a() {
        return this.f29494b;
    }

    public byte[] b() {
        if (this.f29493a == null) {
            this.f29493a = f.b(this.f29494b);
        }
        return this.f29493a;
    }

    public boolean c() {
        if (this.f29494b != null) {
            return true;
        }
        byte[] bArr = this.f29493a;
        return bArr != null && bArr.length > 0;
    }

    public boolean d() {
        byte[] bArr = this.f29493a;
        return bArr != null && bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70;
    }

    public Map<String, String> e() {
        return this.f29496d;
    }

    public void a(List<d.c.c.b.d.a> list) {
        this.f29495c = list;
    }

    public void a(Map<String, String> map) {
        this.f29496d = map;
    }

    public d(Bitmap bitmap) {
        this.f29493a = null;
        this.f29494b = null;
        this.f29495c = null;
        this.f29496d = null;
        this.f29494b = bitmap;
    }
}

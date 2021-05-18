package com.bytedance.sdk.openadsdk.i.a;

import android.graphics.Bitmap;
import com.bytedance.sdk.openadsdk.utils.f;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f29326a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f29327b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.b.c.b.d.a> f29328c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f29329d;

    public d(byte[] bArr) {
        this.f29326a = null;
        this.f29327b = null;
        this.f29328c = null;
        this.f29329d = null;
        this.f29326a = bArr;
    }

    public Bitmap a() {
        return this.f29327b;
    }

    public byte[] b() {
        if (this.f29326a == null) {
            this.f29326a = f.b(this.f29327b);
        }
        return this.f29326a;
    }

    public boolean c() {
        if (this.f29327b != null) {
            return true;
        }
        byte[] bArr = this.f29326a;
        return bArr != null && bArr.length > 0;
    }

    public boolean d() {
        byte[] bArr = this.f29326a;
        return bArr != null && bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70;
    }

    public Map<String, String> e() {
        return this.f29329d;
    }

    public void a(List<d.b.c.b.d.a> list) {
        this.f29328c = list;
    }

    public void a(Map<String, String> map) {
        this.f29329d = map;
    }

    public d(Bitmap bitmap) {
        this.f29326a = null;
        this.f29327b = null;
        this.f29328c = null;
        this.f29329d = null;
        this.f29327b = bitmap;
    }
}

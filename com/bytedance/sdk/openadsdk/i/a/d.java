package com.bytedance.sdk.openadsdk.i.a;

import android.graphics.Bitmap;
import com.bytedance.sdk.openadsdk.utils.f;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f29358a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f29359b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.b.c.b.d.a> f29360c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f29361d;

    public d(byte[] bArr) {
        this.f29358a = null;
        this.f29359b = null;
        this.f29360c = null;
        this.f29361d = null;
        this.f29358a = bArr;
    }

    public Bitmap a() {
        return this.f29359b;
    }

    public byte[] b() {
        if (this.f29358a == null) {
            this.f29358a = f.b(this.f29359b);
        }
        return this.f29358a;
    }

    public boolean c() {
        if (this.f29359b != null) {
            return true;
        }
        byte[] bArr = this.f29358a;
        return bArr != null && bArr.length > 0;
    }

    public boolean d() {
        byte[] bArr = this.f29358a;
        return bArr != null && bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70;
    }

    public Map<String, String> e() {
        return this.f29361d;
    }

    public void a(List<d.b.c.b.d.a> list) {
        this.f29360c = list;
    }

    public void a(Map<String, String> map) {
        this.f29361d = map;
    }

    public d(Bitmap bitmap) {
        this.f29358a = null;
        this.f29359b = null;
        this.f29360c = null;
        this.f29361d = null;
        this.f29359b = bitmap;
    }
}

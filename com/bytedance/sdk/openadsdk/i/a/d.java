package com.bytedance.sdk.openadsdk.i.a;

import android.graphics.Bitmap;
import com.bytedance.sdk.openadsdk.utils.f;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f29186a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f29187b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.c.c.b.d.a> f29188c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f29189d;

    public d(byte[] bArr) {
        this.f29186a = null;
        this.f29187b = null;
        this.f29188c = null;
        this.f29189d = null;
        this.f29186a = bArr;
    }

    public Bitmap a() {
        return this.f29187b;
    }

    public byte[] b() {
        if (this.f29186a == null) {
            this.f29186a = f.b(this.f29187b);
        }
        return this.f29186a;
    }

    public boolean c() {
        if (this.f29187b != null) {
            return true;
        }
        byte[] bArr = this.f29186a;
        return bArr != null && bArr.length > 0;
    }

    public boolean d() {
        byte[] bArr = this.f29186a;
        return bArr != null && bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70;
    }

    public Map<String, String> e() {
        return this.f29189d;
    }

    public void a(List<d.c.c.b.d.a> list) {
        this.f29188c = list;
    }

    public void a(Map<String, String> map) {
        this.f29189d = map;
    }

    public d(Bitmap bitmap) {
        this.f29186a = null;
        this.f29187b = null;
        this.f29188c = null;
        this.f29189d = null;
        this.f29187b = bitmap;
    }
}

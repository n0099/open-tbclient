package com.bytedance.sdk.openadsdk.i.a;

import android.graphics.Bitmap;
import com.bytedance.sdk.openadsdk.utils.f;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f30081a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f30082b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.b.c.b.d.a> f30083c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f30084d;

    public d(byte[] bArr) {
        this.f30081a = null;
        this.f30082b = null;
        this.f30083c = null;
        this.f30084d = null;
        this.f30081a = bArr;
    }

    public Bitmap a() {
        return this.f30082b;
    }

    public byte[] b() {
        if (this.f30081a == null) {
            this.f30081a = f.b(this.f30082b);
        }
        return this.f30081a;
    }

    public boolean c() {
        if (this.f30082b != null) {
            return true;
        }
        byte[] bArr = this.f30081a;
        return bArr != null && bArr.length > 0;
    }

    public boolean d() {
        byte[] bArr = this.f30081a;
        return bArr != null && bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70;
    }

    public Map<String, String> e() {
        return this.f30084d;
    }

    public void a(List<d.b.c.b.d.a> list) {
        this.f30083c = list;
    }

    public void a(Map<String, String> map) {
        this.f30084d = map;
    }

    public d(Bitmap bitmap) {
        this.f30081a = null;
        this.f30082b = null;
        this.f30083c = null;
        this.f30084d = null;
        this.f30082b = bitmap;
    }
}
